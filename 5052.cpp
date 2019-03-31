#include <iostream>
#include <string>
using namespace std;

typedef struct a{
	bool check;
	a *next[10];

	a()
	{
		check = false;
		for (int i = 0; i < 10; i++) next[i] = NULL;
	}
}tri;

int testCase, num, top=-1;
string tell[100001];
tri* first;
tri* stack[100001];

tri* getTop() { return stack[top]; }

void push(tri* item)
{
	top++;
	stack[top] = item;
}

void pop()
{
	top--;
}

void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	string pivot = tell[(left + right) / 2];

	while (leftIndex <= rightIndex)
	{
		while (tell[leftIndex] < pivot) leftIndex++;
		while (tell[rightIndex] > pivot) rightIndex--;

		if (leftIndex <= rightIndex)
		{
			swap(tell[leftIndex], tell[rightIndex]);
			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}

void deleteTri()
{
	tri* ptr = first;
	top = -1;
	push(ptr);

	while (top == -1)
	{
		ptr = getTop();

		for (int i = 0; i < 10; i++)
		{
			if (ptr->next[i] != NULL)
			{
				push(ptr->next[i]);
				break;
			}

			if (i == 9)
			{
				delete ptr;
				pop();
			}
		}
	}
}

int main()
{
	bool flag = true;
	cin >> testCase;
	first = new tri();

	while (testCase--)
	{
		flag = true;
		top = -1;
		cin >> num;
		for (int i = 0; i < num; i++) cin >> tell[i];
		quickSort(0, num - 1);

		for (int i = 0; i < num; i++)
		{
			int size = tell[i].size();
			string temp = tell[i];
			tri* ptr = first;

			for (int j = 0; j < size; j++)
			{
				int index = temp[j] - '0';
				if (ptr->next[index] == NULL) ptr->next[index] = new tri();

				ptr = ptr->next[index];
				if (ptr->check == true)
				{
					flag = false;
					break;
				}
			}

			if (flag == false) break;
			ptr->check = true;
			push(ptr);
		}

		if (flag == false)
		{
			cout << "NO\n";
		}
		else cout << "YES\n";

		while (top != -1)
		{
			tri* ptr = getTop();
			ptr->check = false;
			pop();
		}
	}

	deleteTri();
	return 0;
}