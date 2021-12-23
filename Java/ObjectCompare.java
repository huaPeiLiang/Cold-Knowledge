import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectCompare {

    public class Person{

        private String name;

        private String age;

        private String phone;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    /**
     * 第一题：对象比较
     * */
    @Test
    public void objectCompare(){
        Person martin = new Person();
        Person aaron = new Person();
        System.out.println(martin == aaron);
        System.out.println(martin.equals(aaron));
        martin.setName("martin");
        martin.setAge("20");
        aaron.setName("aaron");
        aaron.setAge("20");
        System.out.println(martin == aaron);
        System.out.println(martin.equals(aaron));
    }

    /**
     * 第二题：去重
     * */
    @Test
    public void removeRepeat(){
        List<Person> personList = new ArrayList<>();

        Person martinHua = new Person();
        martinHua.setName("martin");
        martinHua.setAge("20");
        martinHua.setPhone("13000000000");

        Person aaronWang = new Person();
        aaronWang.setName("aaron");
        aaronWang.setAge("20");
        aaronWang.setPhone("13000000000");

        Person martinChen = new Person();
        martinChen.setName("martin");
        martinChen.setAge("21");
        martinChen.setPhone("13000000000");

        Person aaronzhang = new Person();
        aaronzhang.setName("aaron");
        aaronzhang.setAge("20");
        aaronzhang.setPhone("13100000000");

        personList.add(martinHua);
        personList.add(aaronWang);
        personList.add(martinChen);
        personList.add(aaronzhang);

        Set<Person> personHashSet = new HashSet<>(personList);
        List<Person> removeRepeatPersonListByHashSet = personHashSet.stream().collect(Collectors.toList());
        removeRepeatPersonListByHashSet.forEach(person -> System.out.println(String.format("name: %s，age: %s, phone: %s", person.name, person.age, person.phone)));

        Set<Person> personLinkedHashSet = new LinkedHashSet<>(personList);
        List<Person> removeRepeatPersonListByLinkedHashSet = personLinkedHashSet.stream().collect(Collectors.toList());
        removeRepeatPersonListByLinkedHashSet.forEach(person -> System.out.println(String.format("name: %s，age: %s, phone: %s", person.name, person.age, person.phone)));
    }

}

/*
    第一题：
        重写 equals、hashCode 方法进行比较。
    答案：
        false
        true
        false
        false

    第二题：
        LinkedHashSet 可以保证放入时的顺序（拓展：TreeSet 可以保证自然顺序，可以自定义排序规则）
    答案：
        name: aaron，age: 20, phone: 13000000000
        name: martin，age: 20, phone: 13000000000
        name: martin，age: 21, phone: 13000000000
        name: martin，age: 20, phone: 13000000000
        name: aaron，age: 20, phone: 13000000000
        name: martin，age: 21, phone: 13000000000
 */