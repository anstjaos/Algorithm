#include <iostream>
#include <string>
using namespace std;

int testCase;
string input;
int num;
int queue[10001];
int front = 0;
int rear = 0;

void push(int item)
{
	queue[++rear] = item;
}


int isEmpty()
{
	if (front == rear) return 1;
	else return 0;
}
int pop()
{
	if (isEmpty() == 1)
	{
		return -1;
	}
	else
	{
		front++;
		return queue[front];
	}
}

int getSize()
{
	return (rear - front);
}


void getFront()
{
	if (isEmpty() == 1) cout << -1 << endl;
	else cout << queue[front + 1] << endl;
}

void getBack()
{
	if (isEmpty() == 1) cout << -1 << endl;
	else cout << queue[rear] << endl;
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> input;
		
		if (input == "push")
		{
			cin >> num;
			push(num);
		}
		else if (input == "pop")
		{
			cout << pop() << endl;
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