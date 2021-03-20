#include <stdio.h>
#define MAX_NODES 10001
#define INF 2123456789

typedef struct {
	int cnt;
	int left;
	int right;
}Node;

int low[MAX_NODES], high[MAX_NODES], N, nodeIndex;
Node nodes[MAX_NODES];

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

void dfs(int cur, int cnt)
{
	if (nodes[cur].left != -1) dfs(nodes[cur].left, cnt+1);

	low[cnt] = min(low[cnt], nodeIndex);
	high[cnt] = max(high[cnt], nodeIndex++);

	if (nodes[cur].right != -1) dfs(nodes[cur].right, cnt + 1);
}

int main()
{
	scanf("%d", &N);
	for (register int i = 1; i <= N; i++) low[i] = INF;
	int parent, left, right;

	for (register int i = 0; i < N; i++) {
		scanf("%d %d %d", &parent, &left, &right);
		nodes[parent].cnt++;

		if (left != -1) nodes[left].cnt++;
		nodes[parent].left = left;
		if (right != -1) nodes[right].cnt++;
		nodes[parent].right = right;
	}

	int root = 0;
	nodeIndex = 1;
	for (register int i = 1; i <= N; i++) {
		if (nodes[i].cnt == 1) {
			root = i;
			break;
		}
	}

	dfs(root, nodeIndex);

	int width = high[1] - low[1] + 1, level = 1;
	for (register int i = 2; i <= N; i++) {
		int temp = high[i] - low[i] + 1;
		if (temp > width) {
			width = temp;
			level = i;
		}
	}

	printf("%d %d\n", level, width);
	return 0;
}