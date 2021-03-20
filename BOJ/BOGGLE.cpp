#include <stdio.h>
#include <cstring>

typedef struct Point {
	int y;
	int x;
}Point;

int dirY[8] = { -1,-1,0,1,1,1,0,-1 }, dirX[8] = { 0,1,1,1,0,-1,-1,-1 }, dp[5][5][11];
char arr[6][6], input[15];
int tc, N, inputSize;

int max(int a, int b) { return (a > b ? a : b); }

int findText(Point cur, int index)
{
	int &ret = dp[cur.y][cur.x][index];
	if (index == inputSize) return 1;
	if (ret != -1) return ret;
	ret = 0;

	for (register int i = 0; i < 8; i++) {
		int nextY = cur.y + dirY[i];
		int nextX = cur.x + dirX[i];

		if (nextY < 0 || nextX < 0 || nextY >= 5 || nextX >= 5) continue;
		if (arr[nextY][nextX] != input[index]) continue;

		ret = max(ret, findText({ nextY,nextX }, index + 1));
	}
	return ret;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		for (register int i = 0; i < 5; i++) scanf("%s", arr[i]);
		scanf("%d", &N);
		for (register int i = 0; i < N; i++) {
			scanf("%s", input);
			printf("%s ", input);

			memset(dp, -1, sizeof(dp));

			inputSize = 0;
			while (input[inputSize] != '\0') inputSize++;

			bool find = false;
			for (register int j = 0; j < 5; j++) {
				for (register int k = 0; k < 5; k++) {
					if (arr[j][k] == input[0]) {
						find = findText({ j,k }, 1);
						if (find) break;
					}
				}
				if (find) break;
			}

			find == true ? printf("YES\n") : printf("NO\n");
		}
	}
	return 0;
}