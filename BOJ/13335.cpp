#include <iostream>
#include <queue>
using namespace std;

typedef struct {
	int weight, leftTime;
}tr;

int n, w, l, truck[1001];

int solve()
{
	int time = 0;
	queue<tr> q;
	int index = 1;
	q.push({ truck[0], w });

	while (!q.empty())
	{
		time++;
		int size = q.size();
		int total = 0;
		for (int i = 0; i < size; i++)
		{
			tr cur = q.front();
			q.pop();

			cur.leftTime--;

			if (cur.leftTime >= 0)
			{
				total += cur.weight;
				q.push(cur);
			}
		}

		if (truck[index] + total <= l && index < n)
		{
			index++;
			q.push({ truck[index], w-1 });
		}
	}

	return time;
}

int main()
{
	scanf("%d %d %d", &n, &w, &l);

	for (int i = 0; i < n; i++) scanf("%d", &truck[i]);

	printf("%d\n", solve());
	return 0;
}