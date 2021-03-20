#include <iostream>
using namespace std;

typedef struct ed{
	int vertex;
	ed *next;

	ed() {}
	ed(int i_vertex, ed* i_next)
	{
		vertex = i_vertex;
		next = i_next;
	}
}edge;


int testCase, vertex1, vertex2, color[20001],vertexCnt, edgeCnt;
bool visit[20001];
int queue[20001], front, rear;
edge* vertexArr[20001];

void push(int item)
{
	rear = (rear + 1) % 20001;
	queue[rear] = item;
}

void pop()
{
	front = (front + 1) % 20001;
}

int getFront()
{
	int temp = (front + 1) % 20001;
	return queue[temp];
}

bool bfs(int start)
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
		int cnt = 0;

		edge *curPt = vertexArr[cur];

		while (curPt != 0)
		{
			int next = curPt->vertex;

			if (color[next] == -1) color[next] = (color[cur] + 1) % 2;
			else
			{
				if (next != cur && color[next] == color[cur]) return false;
			}
			push(next);
			curPt = curPt->next;
		}
	}
	return true;
}

void input(int index, int vertex)
{
	if (vertexArr[index] == 0)
	{
		vertexArr[index] = new edge(vertex, 0);
	}
	else
	{
		edge* temp = vertexArr[index];
		vertexArr[index] = new edge(vertex, temp);
	}
}

void reset(int index)
{
	edge *cur = vertexArr[index];
	while (1)
	{
		if (cur == 0) break;
		edge *temp = cur;
		cur = cur->next;
		delete temp;
	}
}

int main()
{
	cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		bool flag = true;
		cin >> vertexCnt >> edgeCnt;
		for (int i = 1; i <= vertexCnt; i++)
		{
			color[i] = -1;
			vertexArr[i] = 0;
			visit[i] = false;
		}

		for (int i = 0; i < edgeCnt; i++)
		{
			cin >> vertex1 >> vertex2;
			input(vertex1, vertex2);
			input(vertex2, vertex1);
		}

		
		for (int i = 1; i <= vertexCnt; i++)
		{
			if (bfs(i) == false)
			{
				flag = false;
				break;
			}
		}

		if (flag == true) cout << "YES" << '\n';
		else cout << "NO" << '\n';

		for (int i = 1; i <= vertexCnt; i++) reset(i);
	}
}