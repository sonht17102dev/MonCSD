package SortCoBanVaSearch;

import java.util.Scanner;
class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class SimpleSort {
    void display(int[] a) {
        int i;
        for (i = 0; i < a.length; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    //==================================================
// Swap element at position i with element at position k
    void swap(int[] a, int i, int k){
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
    int[] copyArray(int[] a){
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = a[i];
        return b;
    }
    //==================================================
    void bubbleSort(int[] a){
        int[] b = copyArray(a);
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1; j++) {
                if(b[j] > b[j+1])
                    swap(b, j+1,j);
            }
        }
        display(b);
    }
    void selectSort(int[] a) {
        //lưu giá trị mảng a vào mảng b
        int[] b = copyArray(a);
        //sắp xếp trên mảng b
        int i,j, minIndex;
        for (i = 0; i < b.length - 1; i++) {
            minIndex = i;
            for (j = i+1; j < b.length; j++) {
                if(b[j] < b[minIndex])
                    minIndex = j;
            }
            swap(b,i,minIndex);
        }
        //hiển thị kết quả sắp xếp
        display(b);
    }

    //==================================================
    int[] insertSort(int[] a) {
        //sắp xếp mảng b
        int[] b = copyArray(a);
        int i,j, temp;
        for (i = 0; i < b.length; i++) {
            temp = b[i];
            j = i-1;
            while (j>=0 && b[j] > temp){
                b[j+1] = b[j];
                j--;
            }
            b[j+1] = temp;
        }

        //hiển thị kết quả sắp xếp
        display(b);
        return b;
    }
    void insertSort(Person[] persons){
        int i,j;
        Person temp;
        for (i = 0; i < persons.length; i++) {
            temp = persons[i];
            j = i - 1;
            while (j>= 0  && persons[j].name.compareTo(temp.name) > 0){
                persons[j+1] = persons[j];
                j--;
            }
            persons[j+1] = temp;
        }
        for (int k = 0; k < persons.length; k++) {
            System.out.print(persons[k].name + " ");
        }
    }
    //==================================================

    int search(int[] a, int value) {
        int index=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == value)
                index = i;
        }
        return  index;
    }
    int binarySearch(int[] a, int left, int right, int value) {
        if(left<=right){
            int mid = left + (right - left) / 2;
            if(a[mid] == value) return  mid;
            else if( value > a[mid])
                return binarySearch(a, mid + 1, right, value);
            else
                return binarySearch(a, left, mid - 1,value);
        }
        return  -1;
    }
    void timKiemNhiPhan(int[] a){
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap value: ");
        int value1 = s.nextInt();
        int[] sorted = copyArray(a);
        sorted = insertSort(a);
        System.out.printf("Binary Search(%d) : %d",
                value1, binarySearch(sorted,0,sorted.length - 1, value1));
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, choice;
        int[] a = {5, 7, 11, 3, 9, 2, 6};
        Person[] persons = {new Person(1,"Nam"), new Person(2,"Mai"), new Person(3,"Hoa")};
        SimpleSort t = new SimpleSort();
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Bubble sort");
            System.out.println("  2. Selection sort");
            System.out.println("  3. Insertion sort");
            System.out.println("  4. Search");
            System.out.println("  5. Binary Search");
            System.out.println("  6. Sort by Name");
            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 6): ");
            choice = s.nextInt();
            if (choice == 0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1:
                    t.bubbleSort(a);
                    break;
                case 2:
                    t.selectSort(a);
                    break;
                case 3:
                    t.insertSort(a);
                    break;
                case 4:
                    System.out.print("Nhap value: ");
                    int value = s.nextInt();
                    System.out.printf("Search(%d): %d",value, t.search(a, 11));
                    break;
                case 5:
                    t.timKiemNhiPhan(a);
                    break;
                case 6:
                    t.insertSort(persons);
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}
