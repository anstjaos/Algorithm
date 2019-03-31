#include <iostream>
#include <set>
using namespace std;

int main()
{
	int k;
	char input;
	long long num;
	int testCase;
	cin >> testCase;
	multiset<long long> m;

	for (int j = 0; j < testCase; j++)
	{
		m.clear();
		cin >> k;
		for (int i = 0; i < k; i++)
		{
			cin >> input >> num;

			if (input == 'I')
			{
				m.insert(num);
			}
			else if (input == 'D' && num == 1)
			{
				if(!m.empty() ) m.erase(--m.end());
			}
			else if (input == 'D' && num == -1)
			{
				if (!m.empty()) m.erase(m.begin());
			}
		}
		if (m.empty()) cout << "EMPTY" << endl;
		else
		{
			cout << *(--m.end()) << " " << *(m.begin()) << endl;
		}
	}
}

/*
#include <iostream>
#include <queue>
#include <functional>
using namespace std;

int main()
{
	int k;
	char input;
	long long num;
	int testCase;
	cin >> testCase;

	for (int j = 0; j < testCase; j++)
	{
		priority_queue<long long> max_heap;
		priority_queue<long long, vector<long long>, greater<long long> > min_heap;
		cin >> k;
		for (int i = 0; i < k; i++)
		{
			cin >> input >> num;

			if (input == 'I')
			{
				max_heap.push(num);
				min_heap.push(num);
			}
			else if (input == 'D' && num == -1)
			{
				if (!min_heap.empty()) min_heap.pop();
			}
			else if (input == 'D' && num == 1)
			{
				if (!max_heap.empty()) max_heap.pop();
			}
		}
		if (max_heap.empty() || min_heap.empty() || max_heap.top() == min_heap.top()) cout << "EMPTY" << endl;
		else
		{
			cout << max_heap.top() << " " << min_heap.top() << endl;
		}
	}
}

*/




/*
#include <iostream>
#include <algorithm>
#include <functional>
#define MAX_COUNT 10000001
using namespace std;

int queue[MAX_COUNT];
int front;
int rear;

void init()
{
	front = 0;
	rear = 0;
}
bool isEmpty()
{
	if (front == rear) return true;
	else return false;
}
void push(int item)
{
	rear = (rear + 1) % MAX_COUNT;
	queue[rear] = item;
	sort(queue + front+1, queue+rear+1,greater<int>());
}

void popFront()
{
	if (isEmpty()) return;
	front = (front + 1) % MAX_COUNT;
}

void popBack()
{
	if (isEmpty()) return;
	rear = (rear - 1) % MAX_COUNT;
}

int showFront()
{
	return queue[front+1];
}

int showBack()
{
	return queue[rear];
}


int main()
{
	int k;
	char input;
	int num;
	int testCase;
	cin >> testCase;

	for (int j = 0; j < testCase; j++)
	{
		init();
		cin >> k;
		for (int i = 0; i < k; i++)
		{
			cin >> input >> num;

			if (input == 'I')
			{
				push(num);
			}
			else if (input == 'D' && num == -1) popBack();
			else if (input == 'D' && num == 1) popFront();
		}
		if (isEmpty()) cout << "EMPTY" << endl;
		else
		{
			cout << showFront() << " " << showBack() << endl;
		}
	}
}
*/