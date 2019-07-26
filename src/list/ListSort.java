package list;
import java.util.LinkedList;




public class ListSort {
	int[] array = new int[]{1,7,3,4,2,6,5,10,9,8};
	ListNode head = null;
	//测试类
	public static void addNode(ListNode head,int val){
		while(head.next!=null){
			head = head.next;
		}
		head.next = new ListNode(val);
	}
	public static void printList(ListNode head){
		if(head == null){
			System.out.println("Head is null!");
			return;
		}
		System.out.println("\n链表为：");
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}	
	}
	public static void main(String[] args){
		int[] array = new int[]{7,1,3,4,2,6,5,10,9,8};
		ListNode head = null;
		head = new ListNode(array[0]);
		for(int i =1;i<10;i++){
			addNode(head,array[i]);
		}
		printList(head);
		
		//快速排序测试
		//quickSort(head,0,length(head)-1);
		//System.out.println("\n快排结果：");
		//printList(head);
		
		
		//选择排序测试
		printList(selectSort(head));
		
	}
	
	public static ListNode get(ListNode head, int i){
		if(i<0)
			return null;
		while(i>0){
			head = head.next;
			i--;
		}
		return head;
	}
	public static int length(ListNode head){
		int length = 0;
		while(head!=null){
			length++;
			head = head.next;
		}
		return length;
	}
	public static void swap(ListNode head,int i ,int j){
		int temp = 0;
		temp = get(head,i).val;
		get(head,i).val = get(head,j).val;
		get(head,j).val = temp;
	}
	/*链表快排
	 * 
	 * 
	 * */
	public static void quickSort(ListNode head,int left,int right){
		//注意先判断，因为每次quikSort(head,i+1,right)不一定会到哪
		if(left >= right)
			return;
		int pivot = get(head,left).val;
		if(head == null||head.next == null)
			return;
		
		int i = left;
		int j = i+1;
		while(j<=right){
			if(get(head,j).val>=pivot){
				j++;
			}
			else if(get(head,j).val<pivot){
				i++;
				swap(head,i,j);
				j++;
			}
		}
		swap(head,left,i);
		quickSort(head,left,i-1);
		quickSort(head,i+1,right);
	} 
	
	/*选择排序
	 * 
	 * 
	 * 
	 * 
	 * */
	public static ListNode selectSort(ListNode head){
		if(head == null||head.next == null)
			return head;
		ListNode newhead = null;
		ListNode newtail = null;
		ListNode oldhead = head;
		ListNode small = oldhead;
		ListNode smallpre = null;
		while(oldhead!=null){
			smallpre = getSmallestPre(oldhead);
			if(smallpre != null){
				small = smallpre.next;
				smallpre.next = small.next;
				small.next = null;
			}
			//small是头部
			else{
				//这里使得最终可以脱出while
				//注意这里因为while循环，small可能已经不指向头，可能在新队列中
				small = oldhead;
				oldhead = small.next;
			}
			if(newtail == null){
				newhead = small;
				newtail = small;
			}
			else{
				newtail.next = small;
				newtail = small;
			}
		}
		return newhead;
	}
	
	public static ListNode getSmallestPre(ListNode head){
		ListNode smallpre = null;
		ListNode small = head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur!=null){
			if(cur.val<small.val){
				small = cur;
				smallpre = pre;
			}
			pre = cur;
			cur = cur.next;
		}
		//注意如果smallpre为null，说明small没有移动过，也就是small就是头部
		return smallpre;
	}
	
	
	
	
	
	
	
	
	
	
}
