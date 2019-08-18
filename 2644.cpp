#include <iostream>
using namespace std;

typedef struct {
	int index, cnt;
}mv;

int family[101][101], famCnt, target, target1, m, x, y;
int result = -1, front , rear;
bool visit[101];
mv queue[100001];

void push(mv item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

mv getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

void solve()
{
	front = rear = -1;
	push({ target, 0 });
	mv cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if (cur.index == target1)
		{
			result = cur.cnt;
			return;
		}

		for (int i = 1; i <= famCnt; i++)
		{
			if ((family[i][cur.index] == 1 || family[cur.index][i] == 1) && visit[i] == false)
			{
				visit[i] = true;
				push({ i,cur.cnt + 1 });
			}
		}
	}
}

int main()
{
	cin >> famCnt >> target >> target1 >> m;

	for (int i = 0; i < m; i++)
	{
		cin >> x >> y;
		family[x][y] = 1;
	}

	if (family[target][target1] == 1 || family[target1][target] == 1) result = 1;
	else if (target == target1) result = 0;
	else solve();

	cout << result << '\n';
	return 0;
}