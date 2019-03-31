#include <iostream>
using namespace std;

typedef struct {
	int cnt, visitCnt;
}inform;

inform dp[200001];
bool visit[200001];
int queue[1000001], front, rear, start, desti;

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

void bfs()
{
	front = rear = -1;
	push(start);
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (visit[cur] == true) continue;

		visit[cur] = true;
		if (cur == desti) continue;

		if (cur > desti)
		{
			if (dp[cur - 1].cnt == 0 || dp[cur - 1].cnt > dp[cur].cnt + 1)
			{
				dp[cur - 1].visitCnt = dp[cur].visitCnt;

				dp[cur - 1].cnt = dp[cur].cnt + 1;
				push(cur - 1);
			}
			else if (dp[cur - 1].cnt == dp[cur].cnt + 1)
			{
				dp[cur - 1].visitCnt++;
				push(cur - 1);
			}
		}
		else
		{
			if (cur + 1 <= desti && cur + 1 != start)
			{
				if (dp[cur + 1].cnt == 0 || dp[cur + 1].cnt > dp[cur].cnt + 1)
				{
					dp[cur + 1].visitCnt = dp[cur].visitCnt;
					dp[cur + 1].cnt = dp[cur].cnt + 1;

					push(cur + 1);
				}
				else if (dp[cur + 1].cnt == dp[cur].cnt + 1)
				{
					dp[cur + 1].visitCnt++;
					push(cur + 1);
				}
			}
			if (cur * 2 <= desti && cur * 2 != start)
			{
				if (dp[cur * 2].cnt == 0 || dp[cur * 2].cnt > dp[cur].cnt + 1)
				{
					dp[cur * 2].visitCnt = dp[cur].visitCnt;
					dp[cur * 2].cnt = dp[cur].cnt + 1;

					push(cur * 2);
				}
				else if (dp[cur * 2].cnt == dp[cur].cnt + 1)
				{
					dp[cur * 2].visitCnt++;
					push(cur * 2);
				}
			}
			if (cur - 1 >= 0 && cur - 1 != start)
			{
				if (dp[cur - 1].cnt == 0 || dp[cur - 1].cnt > dp[cur].cnt + 1)
				{
					dp[cur - 1].visitCnt = dp[cur].visitCnt;

					dp[cur - 1].cnt = dp[cur].cnt + 1;

					push(cur - 1);
				}
				else if (dp[cur - 1].cnt == dp[cur].cnt + 1)
				{
					dp[cur - 1].visitCnt++;
					push(cur - 1);
				}
			}
		}

	}
}
int main()
{
	cin >> start >> desti;
	dp[start].visitCnt = 1;
	bfs();
	cout << dp[desti].cnt << '\n' << dp[desti].visitCnt << '\n';
	return 0;
}