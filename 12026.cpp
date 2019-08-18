#include <stdio.h>
#define QUEUE_SIZE 100005

typedef struct {
	int cur;
	char c;
}Block;

Block queue[QUEUE_SIZE];
int N, arr[1001], front, rear;
char map[1001];

void push(Block b)
{
	rear = (rear + 1) % QUEUE_SIZE;
	queue[rear] = b;
}

Block pop()
{
	front = (front + 1) % QUEUE_SIZE;
	return queue[front];
}

void bfs()
{
	front = rear = -1;
	push({ 0,'B' });

	while (front != rear)
	{
		Block curBlock = pop();
		char next = 'O';

		switch (curBlock.c) {
		case 'B':
			next = 'O';
			break;
		case 'O':
			next = 'J';
			break;
		case 'J':
			next = 'B';
			break;
		}

		for (register int i = curBlock.cur + 1; i < N; i++) {
			if (map[i] == next) {
				int k = i - curBlock.cur;
				if (arr[i] == 0 || arr[curBlock.cur] + (k*k) < arr[i]) {
					arr[i] = arr[curBlock.cur] + (k*k);
					push({ i, next });
				}
			}
		}
	}
}

int main()
{
	scanf("%d %s", &N, map);
	bfs();

	arr[N - 1] == 0 ? printf("-1\n") : printf("%d\n", arr[N - 1]);
	return 0;
}