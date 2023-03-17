package Array_Search_Insert_Delete_SearchObject;
import java.util.Arrays;
public class TimKiem_Chen_Xoa_ArrayOrdered {
    public static void main(String[] args) {
        OrderedArray oa = new OrderedArray(10);
        oa.insert(5);
        oa.insert(4);
        oa.insert(10);
        oa.insert(7);
        oa.insert(3);
        oa.insert(6);
        System.out.println(oa);
        System.out.println("Search(7): " + oa.binarySearch(5,0,oa.size()));
        oa.delete(5);
        oa.insert(8);
        System.out.println(oa);
    }
}
class OrderedArray {
    /*
     Tôi đã sử dụng Integer, thay vì int, để chúng ta có thể thực hiện kiểm tra null
     để xem liệu dữ liệu có ở một chỉ mục cụ thể hay không.
     Điều này là do java tự động khởi tạo tất cả các phần tử của mảng, do đó,
     một int [] sẽ được khởi tạo tất cả các giá trị 0. Vì vậy, sẽ rất khó để biết liệu số 0
     thực sự được chèn vào như một phần của dữ liệu hay đó là số 0 được khởi tạo.
     */
    private Integer[] data;

    /**
     * Chúng ta có thể tạo một OrderArray có thể
     * chứa dữ liệu tối đa với kích thước này
     * @param size
     */
    public OrderedArray(int size) {
        this.data = new Integer[size];
    }

    public OrderedArray() {
        this(100); // default size of the array is 100.
    }

    /**
     * This method implements the binary search algorithm
     * in an iterative(VÒNG LẶP) way
     * @param item
     * @return the index of the item if found, -1 otherwise
     */
    public int binarySearch(int item) {
        int right = size()-1;
        int left = 0;
        int mid =(left + right) / 2;
        while ((data[mid] != item) && (right > left)) {
            if (data[mid] > item) { // case to search on the left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        if (data[mid] == item) return mid;
        return -1;
    }

    /**
     * This method implements the binary search algorithm
     * in a recursive (ĐỆ QUY) way
     * @param item
     * @return the index of the item if found, -1 otherwise
     */
//	public int binarySearch(int item) {
//		return binarySearch(item, 0, size()-1);
//	}
    public int binarySearch(int item, int minIndex, int maxIndex) {
        if(minIndex <=maxIndex){
            int mid = minIndex + (maxIndex - minIndex) / 2;
            if (data[mid] == item) return mid;
            else if(item > data[mid])
                return binarySearch(item, mid + 1, maxIndex);
            else
                return binarySearch(item, minIndex, mid - 1);
        }
        return -1;
    }

    void insert(int item) {
        int i = 0;
        while ((i < data.length) && (data[i] != null)) {
            if (data[i] > item)
                break;
            i++;
        }
        /*
         * right now i must be pointing to the element which is just greater
         * than item so we need to first move all elements from index i onwards
         * to right by one
         * ngay bây giờ tôi phải trỏ đến phần tử giá trị lớn hơn
         * so với item, vì vậy trước tiên chúng tôi cần
         * di chuyển tất cả các phần tử từ chỉ mục i trở đi sang phải từng phần tử
         */
        shiftElementsToRight(i);
        data[i] = item;
    }

    void delete(int item) {
        int i = binarySearch(item);
        if (i >= 0) {
            shiftElementsToLeft(i + 1);
        }
    }

    /*
     * This method gives the size upto which elements are present. Because
     * array length is fixed, all elements will be null initially, then as and
     * when we add elements, the elements will become not null. So this tells
     * how many elements are really present in this ordered array
     *
     * Phương thức này cung cấp kích thước tối đa cho các phần tử hiện diện. Bởi vì độ dài mảng
     * là cố định, ban đầu tất cả các phần tử sẽ là null, sau đó khi chúng ta thêm các phần tử vào,
     * các phần tử sẽ không trở thành null. Vì vậy, điều này cho biết
     * có bao nhiêu phần tử thực sự hiện diện trong mảng có thứ tự này
     */
    int size() {
        int i = 0;
        while ((i < data.length) && (data[i] != null)) {
            i++;
        }
        return i;
    }
    // Hàm dịch phần tử mảng sang phải
    void shiftElementsToRight(int startIndex) {
        for (int i = size()-1; i >= startIndex; i--) {
            data[i + 1] = data[i];
        }
    }
    // Hàm dịch phần tử mảng sang trái
    void shiftElementsToLeft(int startIndex) {
        int maxIndex = size()-1;
        for (int i = startIndex; i <= maxIndex; i++) {
            data[i - 1] = data[i];
        }
        data[maxIndex] = null;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.data);
    }
}
