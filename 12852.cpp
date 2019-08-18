#include <iostream>
using namespace std;

typedef struct {
	int cnt, preNum;
}num;

num dp[10000001];
int queue[10000001], front, rear;
int start;

void push(int index)
{
	rear = (rear + 1) % 1000001;
	queue[rear] = index;
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

void init()
{
	front = rear = -1;
	push(1);
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur == start) break;

		if (dp[cur * 3].cnt == 0 && cur * 3 <= start)
		{
			push(cur * 3);
			dp[cur * 3].cnt = dp[cur].cnt + 1;
			dp[cur * 3].preNum = cur;
		}
		

		if (dp[cur * 2].cnt == 0 && cur * 2 <= start)
		{
			push(cur * 2);
			dp[cur * 2].cnt = dp[cur].cnt + 1;
			dp[cur * 2].preNum = cur;
		}
		

		if (dp[cur +1].cnt == 0 && cur + 1 <=start)
		{
			push(cur + 1);
			dp[cur +1].cnt = dp[cur].cnt + 1;
			dp[cur +1].preNum = cur;
		}
		
	}
}

int main()
{
	cin >> start;
	init();

	int cur = start;
	cout << dp[cur].cnt << '\n';
	while (1)
	{
		cout << cur << " ";
		if (cur == 1) break;
		cur = dp[cur].preNum;
	}
	return 0;
}