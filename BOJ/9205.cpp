#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}mv;

int testCase, cvsCnt, front, rear, x, y;
mv start, desti, cvs[101];
int queue[100001];

void push(int item)
{
	rear = (rear + 1) % 100001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 100001;
}

int getFront()
{
	int temp = (front + 1) % 100001;
	return queue[temp];
}

bool bfs(int index)
{
	front = rear = -1;
	bool visit[101];
	for (int i = 0; i < cvsCnt; i++) visit[i] = false;

	push(index);
	int cur;

	while (front != rear)
	{
		cur = getFront();
		pop();

		if ((abs(desti.x - cvs[cur].x) + abs(desti.y - cvs[cur].y)) / 50 < 20) return true;
		else if ((abs(desti.x - cvs[cur].x) + abs(desti.y - cvs[cur].y)) / 50 == 20
			&& (abs(desti.x - cvs[cur].x) + abs(desti.y - cvs[cur].y)) % 50 == 0) return true;

		if (visit[cur] == true) continue;

		visit[cur] = true;
		
		for (int i = 0; i < cvsCnt; i++)
		{
			if ((abs(cvs[i].x - cvs[cur].x) + abs(cvs[i].y - cvs[cur].y)) / 50 < 20 && visit[i] == false)
			{
				push(i);
			}
			else if ((abs(cvs[i].x - cvs[cur].x) + abs(cvs[i].y - cvs[cur].y)) / 50 == 20
				&& (abs(cvs[i].x - cvs[cur].x) + abs(cvs[i].y - cvs[cur].y)) % 50 == 0 && visit[i] == false) push(i);
		}
	}
	return false;
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> cvsCnt >> start.x >> start.y;

		for (int j = 0; j < cvsCnt; j++)
		{
			cin >> x >> y;
			cvs[j] = { x,y };
		}
		cin >> desti.x >> desti.y;

		if ((abs(desti.x - start.x) + abs(desti.y - start.y)) / 50 <= 20)
		{
			if ((abs(desti.x - start.x) + abs(desti.y - start.y)) / 50 == 20 &&
				(abs(desti.x - start.x) + abs(desti.y - start.y)) % 50 == 0)
			{
				cout << "happy" << endl;
				continue;
			}
			else if ((abs(desti.x - start.x) + abs(desti.y - start.y)) / 50 < 20)
			{
				cout << "happy" << endl;
				continue;
			}
		}

		bool result = false;
		for (int j = 0; j < cvsCnt; j++)
		{
			if ((abs(cvs[j].x - start.x) + abs(cvs[j].y - start.y)) / 50 < 20)
			{
				result = bfs(j);
			}
			else if((abs(cvs[j].x - start.x) + abs(cvs[j].y - start.y)) / 50 == 20
				&& (abs(cvs[j].x - start.x) + abs(cvs[j].y - start.y)) % 50 == 0) result = bfs(j);

			if (result == true) break;
		}

		if (result == true)
		{
			cout << "happy" << endl;
		}
		else cout << "sad" << endl;
	}
}