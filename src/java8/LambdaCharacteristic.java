package java8;

import java8.pojo.Fruit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class LambdaCharacteristic {
    public static void main(String[] args) {
//        streamForeach();
//        streamMap();
//        streamFilter();
//        sortByMapValue();
//        int i = addUp(Stream.of(1, 2, 3, 4, 5));
//        System.out.println(i);
        List<Fruit> fruits = Arrays.asList(new Fruit(), new Fruit(), new Fruit());
        int i = sumId(fruits);
        System.out.println(i);
    }

    /**
     * streamForeach
     */
    public static void streamForeach() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.stream().forEach(string -> {
            System.out.println(string);
        });
    }

    /**
     * streamMap
     */
    public static void streamMap() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> collect = list.stream().map(string -> {
            return "stream().map()处理之后：" + string;
        }).collect(Collectors.toList());

        collect.stream().forEach(string -> {
            System.out.println(string);
        });

        for (String str : list) {
            System.out.println(str);
        }
    }

    /**
     * streamFilter
     */
    public static void streamFilter() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");

        List<String> collect = list.stream().filter(s ->
                !s.equals("3")
        ).collect(Collectors.toList());
        collect.forEach(s -> {
            System.out.println(s);
        });
    }

    /**
     * 通过lambda表达式，对map的value进行排序
     */
    public static void sortByMapValue() {

        // 初始数据
        Map<String, Integer> smap = new HashMap<>();
        smap.put("1", 11);
        smap.put("3", 33);
        smap.put("2", 22);

        // 1.8以前
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>();
        list1.addAll(smap.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : list1) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        // 1.8使用lambda表达式
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>();
        list2.addAll(smap.entrySet());
        Collections.sort(list2, (o1, o2) -> o1.getValue() - o2.getValue());
        list2.forEach(entry -> {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        });
    }

    /**
     * 编写一个stream的求和方法
     *
     * @param numbers
     * @return
     */
    public static int addUp(Stream<Integer> numbers) {
        Integer reduce = numbers.reduce(0, (x, y) -> x + y);
        return reduce;
    }

    public static int sumId(List<Fruit> fruits) {
//        Integer totalMembers = 0;
//        for (Fruit f : fruits) {
//            Stream<Apple> appleStream = f.getAppleStream();
//            totalMembers += appleStream.count();
//        }
//        int reduce = (Integer)fruits.stream().map(fruit -> fruit.getAppleStream().count()).reduce(new Long(0), (x, y) -> x + y).intValue();
        Integer[] totalMembers = {0};
        fruits.stream().map(fruit -> fruit.getAppleStream().count()).forEach(count -> totalMembers[0] += count.intValue());
        return totalMembers[0];
    }
}
