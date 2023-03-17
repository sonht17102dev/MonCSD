package SortCoBanVaSearch;

import java.util.Arrays;
import java.util.Scanner;

class Person1 {
    int age;
    String name;

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
class SimpleSort1 {
	void display(int[] a) {
        int i;
        for (i = 0; i < a.length; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
	void display(Person1[] a) {
        int i;
        for (i = 0; i < a.length; i++)
            System.out.print("  " + a[i].name);
        System.out.println();
    }
	int[] copy(int[] arr) {
		return Arrays.copyOf(arr, arr.length);
	}
    //==================================================
// Swap element at position i with element at position k
    void swap(int[] a, int i, int k){
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
    
	void bubbleSort(int[] arr) {
		int[] a = copy(arr);
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if(a[j] > a[j+1])
					swap(a, j + 1, j);
			}
			display(a);
		}
	}
	void selectSort(int[] arr) {
		int[] a = copy(arr);
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if(a[minIndex] > a[j])
					minIndex = j;
			}
			swap(a, i, minIndex);
			display(a);
		}
	}
	void insertSort(int[] arr) {
		int[] a = copy(arr);
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int j = i - 1;
			while (j>=0 && a[j] > temp) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
			display(a);
		}
	}
	void insertSort(Person1[] persons) {
		Person1 temp;
		for (int i = 0; i < persons.length; i++) {
			temp = persons[i];
			int j= i -1;
			while (j>=0 && persons[j].name.compareTo(temp.name) > 0) {
				persons[j+1] = persons[j];
				j--;
			}
			persons[j+1] = temp;
			display(persons);
		}
	}
	int search(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == key)
				return i;
		}
		return -1;
	}
	int binarySearch(int[] arr, int key, int low, int high) {
		if(low > high) return -1;
		int mid = (low + high) / 2;
		if(arr[mid] == key) {
			return mid;
		} else if(arr[mid] < key) {
			return binarySearch(arr, key, mid + 1, high);
		} else {
			return binarySearch(arr, key, low, mid - 1);
		}
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, choice;
		int[] a = { 5, 7, 11, 3, 9, 2, 6 };
		Person1[] persons = { new Person1(1, "Nam"), new Person1(2, "Mai"), new Person1(3, "Hoa") };
		SimpleSort1 t = new SimpleSort1();
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
				if (t.search(a, value) == -1) {
					System.out.printf("Search(%d): %d\n", value, t.search(a, value));
					System.out.println("Khong tim thay phan tu " + value);
				} else {
					System.out.printf("Search(%d): %d\n", value, t.search(a, value));
					System.out.println("Da tim thay phan tu " + value);
				}
				break;
			case 5:
				int[] b = Arrays.copyOf(a, a.length);
				Arrays.sort(b);
				System.out.print("Nhap value: ");
				int value1 = s.nextInt();
				if (t.binarySearch(b, value1, 0, a.length - 1) == -1) {
					System.out.printf("Search(%d): %d\n", value1, t.binarySearch(b, value1, 0, a.length - 1));
					System.out.println("Khong tim thay phan tu " + value1);
				} else {
					System.out.printf("Search(%d): %d\n", value1,  t.binarySearch(b, value1, 0, a.length - 1));
					System.out.println("Da tim thay phan tu " + value1);
				}
				break;
			case 6:
				t.insertSort(persons);
				break;
			default:
				System.out.println("**Invalid choice. Try again.**");
			}
		}
		s.close();
	}

}
