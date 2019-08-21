#include <stdio.h>
#include <map>
using namespace std;
#define QUEUE_SIZE 400000

map<int, int> m;
int arr[3][3], queue[QUEUE_SIZE], front, rear;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

void push(int item)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

int changeNum()
{
	int ret = 0;
	for (register int i = 0; i < 3; i++) {
		for (register int j = 0; j < 3; j++) ret = ret * 10 + arr[i][j];
	}
	return ret;
}

void bfs()
{
	front = rear = -1;
	push(changeNum());
	m[changeNum()] = 0;
	char numTochar[9] = { 0, };
	while (front != rear)
	{
		int cur = pop();
		if (cur == 123456789) return;

		int idx = 0;
		int temp = cur;
		for (register int i = 8; i >= 0; i--) {
			numTochar[i] = (temp % 10) + '0';
			temp /= 10;
			if (numTochar[i] == '9') idx = i;
		}

		int x = idx / 3;
		int y = idx % 3;

		for (register int i = 0; i < 4; i++) {
			int nextX = x + dirX[i];
			int nextY = y + dirY[i];

			if (nextX < 0 || nextY < 0 || nextX >= 3 || nextY >= 3) continue;
			int changeIdx = nextX * 3 + nextY;

			char c = numTochar[changeIdx];
			numTochar[changeIdx] = numTochar[idx];
			numTochar[idx] = c;

			int num = 0;
			for (register int j = 0; j < 9; j++) {
				num = num * 10 + (numTochar[j] - '0');
			}

			if (m[num] == 0) {
				m[num] = m[cur] + 1;
				push(num);
			}
			
			c = numTochar[changeIdx];
			numTochar[changeIdx] = numTochar[idx];
			numTochar[idx] = c;
		}
	}
}

int main()
{
	for (register int i = 0; i < 3; i++)
	{
		for (register int j = 0; j < 3; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 0) arr[i][j] = 9;
		}
	}
	if (changeNum() == 123456789) {
		printf("0\n");
		return 0;
	}
	bfs();
	if (m[123456789] == 0) printf("-1\n");
	else printf("%d\n", m[123456789]);
	return 0;
}