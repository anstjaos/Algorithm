#include <iostream>
#include <string>
using namespace std;

int testCase;
string input;
int num;
int deque[10001];
int front = 0;
int rear = 0;

void push_front(int item)
{
	front--;
	if (front < 0) front = 10000;
	int temp = (front + 1) % 10001;
	
	deque[temp] = item;
}

void push_back(int item)
{
	rear = (rear + 1) % 10001;
	deque[rear] = item;
}

int isEmpty()
{
	if (front == rear) return 1;
	else return 0;
}

int pop_front()
{
	if (isEmpty() == 1)
	{
		return -1;
	}
	else
	{
		front = (front + 1) % 10001;
		return deque[front];
	}
}

int pop_back()
{
	if (isEmpty() == 1)
	{
		return -1;
	}
	else
	{
		int temp = deque[rear];
		rear = rear - 1;
		if (rear < 0) rear = 10000;
		return temp;
	}
}

int getSize()
{
	int size = 0;
	if (front > rear)
	{
		size = size + 10001 - front;
		size = size + rear;
	}
	else
	{
		size = rear - front;
	}
	return size;
}


void getFront()
{
	if (isEmpty() == 1) cout << -1 << endl;
	else
	{
		int temp = (front + 1) % 10001;
		cout << deque[temp] << endl;
	}
}

void getBack()
{
	if (isEmpty() == 1) cout << -1 << endl;
	else cout << deque[rear] << endl;
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> input;

		if (input == "push_front")
		{
			cin >> num;
			push_front(num);
		}
		else if (input == "push_back")
		{
			cin >> num;
			push_back(num);
		}
		else if (input == "pop_front")
		{
			cout << pop_front() << endl;
		}
		else if (input == "pop_back")
		{
			cout << pop_back() << endl;
		}
		else if (input == "size")
		{
			cout << getSize() << endl;
		}
		else if (input == "empty")
		{
			cout << isEmpty() << endl;
		}
		else if (input == "front") getFront();
		else if (input == "back") getBack();

	}
	return 0;
}