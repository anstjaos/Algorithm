#include <iostream>
using namespace std;

int queue[1000001], front, rear;
int input;

void push(int item)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 1000001;
}

int getFront()
{
	int temp = (front + 1) % 1000001;
	return queue[temp];
}

int getResult()
{
	front = rear = -1;
	int ans;

	if (input >= 4)
	{
		push(4);
		ans = 4;
	}
	if (input >= 7)
	{
		push(7);
		ans = 7;
	}

	while (front != rear)
	{
		int temp = getFront();
		pop();

		temp = temp * 10;
		if (temp + 4 <= input)
		{
			push(temp + 4);
			ans = temp + 4;
		}
		if (temp + 7 <= input)
		{
			push(temp + 7);
			ans = temp + 7;
		}
	}

	return ans;
}

int main()
{
	cin >> input;

	int result = getResult();
	cout << result << '\n';
	return 0;
}