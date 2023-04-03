package hw1;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array) {
        //Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0 ; i--) { // берем середину массива в кач-ве корня
            heapify(array, array.length, i); //запускаем просеивание
        }

        //Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0 ; i--) {
            //Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    // базовая операция просеивания
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый ребенок, по формуле 2 * i + 1
        int rightChild = 2 * rootIndex + 2; // правый ребенок 2 * i + 2

        // Если левый ребенок больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        //Если дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        //Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

}


