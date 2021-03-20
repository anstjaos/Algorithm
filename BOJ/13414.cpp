#include <iostream>
using namespace std;

typedef struct a{
	int num;
	a* next;

	a() {}
	a(int i_num, a* i_next)
	{
		num = i_num;
		next = i_next;
	}
}node;

node* first;
node* tail;
int arr[500001], arrCnt;
int K, L, result = 0;

void create(int num)
{
	if (first == 0)
	{
		first = new node(num, 0);
		tail = first;
		return;
	}

	tail->next = new node(num, 0);
	tail = tail->next;
}

void deleteNode()
{
	node* ptr = first;

	while (ptr != 0)
	{
		node* temp = ptr;
		ptr = ptr->next;
		delete temp;
	}
}

bool binarySearch(int left, int right, int target)
{
	while (left <= right)
	{
		int mid = (left + right) / 2;
		int pivot = arr[mid];
		
		if (pivot < target) right = mid - 1;
		else if (pivot > target) left = mid + 1;
		else if (pivot == target) return true;
	}
	return false;
}

void findNum(int num)
{
	bool flag = false;
	if (arrCnt != 0 && binarySearch(0, arrCnt - 1, num) == true) flag = true;


}

void input()
{
	cin >> K >> L;
	int num;
	for (int i = 0; i < L; i++)
	{
		cin >> num;

		create(num);
	}
}

int main()
{
	first = 0;
	tail = 0;
	input();

	node* ptr = first;

	while (ptr != 0)
	{
		cout << ptr->num << '\n';
		result++;
		if (result == K) break;
		ptr = ptr->next;
	}
	deleteNode();
	return 0;
}