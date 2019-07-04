#include <stdio.h>
#define MAX_JOB 10001

typedef struct a {
	int num;
	a* next;
}Job;

int N, inCome[MAX_JOB], jobTime[MAX_JOB], poolCnt, arr[MAX_JOB], queue[MAX_JOB], front, rear;
Job *list[MAX_JOB], jobPool[MAX_JOB * 100];

void push(int item)
{
	rear = (rear + 1) % MAX_JOB;
	queue[rear] = item;
}

int pop()
{
	front = (front + 1) % MAX_JOB;
	return queue[front];
}

int max(int a, int b) { return (a > b ? a : b); }

void solve()
{
	front = rear = -1;
	for (register int i = 1; i <= N; i++) {
		if (inCome[i] == 0) {
			push(i);
			jobTime[i] = arr[i];
		}
	}

	while (front != rear) {
		int idx = pop();
		Job *ptr = list[idx];

		while (ptr != 0) {
			int next = ptr->num;
			jobTime[next] = max(jobTime[next], jobTime[idx] + arr[next]);
			inCome[next]--;
			if (inCome[next] == 0) push(next);
			ptr = ptr->next;
		}
	}
}

int main()
{
	int cnt = 0;
	scanf("%d", &N);
	for (register int i = 1; i <= N; i++) {
		scanf("%d %d", arr + i, &cnt);
		inCome[i] = cnt;

		for (register int j = 0; j < cnt; j++) {
			int temp = 0;
			scanf("%d", &temp);

			jobPool[poolCnt].num = i;
			jobPool[poolCnt].next = list[temp];
			list[temp] = &jobPool[poolCnt];
			poolCnt++;
		}
	}

	solve();
	int result = 0;
	for (register int i = 1; i <= N; i++) {
		result = max(result, jobTime[i]);
	}
	printf("%d\n", result);
	return 0;
}