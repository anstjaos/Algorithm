#include <iostream>
#include <functional>
#include <queue>
using namespace std;

priority_queue<int> minHeap;
priority_queue<int, vector<int>, greater<int>> maxHeap;
int N, input;

void print()
{
	if (maxHeap.empty() == true && minHeap.empty())
	{
		cout << "0" << endl;
		return;
	}
	else if (maxHeap.empty() && !minHeap.empty())
	{
		cout << minHeap.top() << endl;
		minHeap.pop();
	}
	else if (!maxHeap.empty() && minHeap.empty())
	{
		cout << maxHeap.top() << endl;
		maxHeap.pop();
	}
	else
	{
		int temp = minHeap.top() * -1;

		if (temp == maxHeap.top() || temp < maxHeap.top())
		{
			cout << minHeap.top() << endl;
			minHeap.pop();
		}
		else if (temp > maxHeap.top())
		{
			cout << maxHeap.top() << endl;
			maxHeap.pop();
		}
	}
}

int main()
{
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> input;

		if (input == 0)
		{
			print();
		}
		else
		{
			if (input < 0)
			{
				minHeap.push(input);
			}
			else
			{
				maxHeap.push(input);
			}
		}
	}
}