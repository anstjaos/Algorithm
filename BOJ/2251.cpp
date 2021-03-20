#include <stdio.h>

typedef struct Water {
	int a, b, c;
}Water;

int A, B, C, front, rear;
Water queue[40005];
bool check[202][202], ans[202];

void push(Water w) {
	rear = (rear + 1) % 40005;
	queue[rear] = w;
}

Water pop()
{
	front = (front + 1) % 40005;
	return queue[front];
}

void bfs()
{
	front = rear = -1;
	push({ 0,0,C });

	while (front != rear)
	{
		Water cur = pop();

		if (check[cur.a][cur.b]) continue;

		check[cur.a][cur.b] = true;

		if (cur.a == 0) ans[cur.c] = true;

		if (cur.a + cur.b > B) push({ (cur.a + cur.b) - B, B, cur.c });
		else push({ 0 , cur.a + cur.b, cur.c });

		if (cur.a + cur.c > C) push({ (cur.a + cur.b) - C, cur.b, C });
		else push({ 0, cur.b, cur.a + cur.c });

		if (cur.b + cur.a > A) push({ A, (cur.b + cur.a) - A, cur.c });
		else push({ cur.b + cur.a, 0, cur.c });

		if (cur.b + cur.c > C) push({ cur.a, (cur.b + cur.c) - C, C });
		else push({ cur.a, 0, cur.b + cur.c });

		if (cur.c + cur.a > A) push({ A, cur.b, (cur.c + cur.a) - A });
		else push({ cur.c + cur.a, cur.b, 0 });

		if (cur.c + cur.b > B) push({ cur.a, B, (cur.c + cur.b) - B });
		else push({ cur.a, cur.c + cur.b, 0 });
	}
}

int main(void)
{
	scanf("%d %d %d", &A, &B, &C);
	bfs();
	for (int i = 0; i <= C; i++)
	{
		if (ans[i]) printf("%d ", i);
	}
	printf("\n");
	return 0;
}
