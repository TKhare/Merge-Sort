import java.util.*;

public class mergeSort {
	//function takes two already sorted lists and sorts them into one bigger lists
	public static void merge(int[] a, int[] l, int[] r)
	{
		int n_L = l.length;
		int n_R = r.length;
		// i marks lowest val in l
		int i = 0;
		// j marks the lowest val in r
		int j = 0;
		//k marks position in A
		int k = 0;
		while (i<n_L&&j<n_R) {
			//fills up big list with values in smaller lists
			if (l[i]<=r[j])
			{
				a[k] = l[i];
				k++;
				i++;
			}
			else 
			{
				a[k] = r[j];
				j++;
				k++;
			}
		}
		//fills big list with any remaining integers in small lists
		while (i<n_L) {
			a[k] = l[i];
			i++;
			k++;
		}
		while (j<n_R) {
			a[k] = r[j];
			j++;
			k++;
		}
	}

	//Called function which creates the smallest lists and then sorts them using merge
	public static void mergesort(int[] a) {
		int n = a.length;
		if (n<2) {
			return;
					
		}
		int a_mid = n/2;
		int[] l1 = new int [a_mid];
		int[] r1 = new int [n-a_mid];
		for (int i = 0; i<a_mid;i++) {
			l1[i] = a[i];
		}
		for (int i = a_mid; i <n;i++) {
			r1[i-a_mid] = a[i];
		}
		mergesort(l1);
		mergesort(r1);
		merge(a, l1, r1);
	}
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("What is the length of your list? "); 
		int n = reader.nextInt();
		int[] arr = new int[n];
		System.out.println("Print each of the items in your list one by one");
		for (int index = 0; index < n; index += 1) {	
			arr[index] = reader.nextInt();
		}
		System.out.println("No more inputs");
		reader.close();
		System.out.println("Original List:");
		System.out.println(Arrays.toString(arr));
		mergesort(arr);
		System.out.println("Sorted List: ");
		System.out.println(Arrays.toString(arr));
		}
	}


