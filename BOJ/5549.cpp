#include <iostream>
using namespace std;

typedef struct {
	int jgCnt, seaCnt, iceCnt;
}mp;

int row, col, K,a,b,c,d;
int jungleCnt, seaCnt, iceCnt;
char temp;
mp map[1005][1005];

int main()
{
	scanf("%d %d %d ", &row, &col, &K);
	
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			
			map[i][j] = map[i][j - 1];
			scanf("%c ", &temp);
		
			if (temp == 'J') map[i][j].jgCnt++;
			else if (temp == 'O')map[i][j].seaCnt++;
			else if (temp == 'I') map[i][j].iceCnt++;
		}

		for (int j = 1; j <= col; j++)
		{
			map[i][j].jgCnt += map[i - 1][j].jgCnt;
			map[i][j].iceCnt += map[i - 1][j].iceCnt;
			map[i][j].seaCnt += map[i - 1][j].seaCnt;
		}
	}

	for (int i = 0; i < K; i++)
	{
		jungleCnt = seaCnt = iceCnt = 0;
		scanf("%d %d %d %d ", &a, &b, &c, &d);
		
		jungleCnt = map[c][d].jgCnt - map[a - 1][d].jgCnt - map[c][b-1].jgCnt + map[a - 1][b - 1].jgCnt;
		seaCnt = map[c][d].seaCnt- map[a - 1][d].seaCnt - map[c][b-1].seaCnt+ map[a - 1][b - 1].seaCnt;
		iceCnt= map[c][d].iceCnt - map[a - 1][d].iceCnt - map[c][b-1].iceCnt + map[a - 1][b - 1].iceCnt;

		printf("%d %d %d\n", jungleCnt, seaCnt, iceCnt);
	}
	return 0;
}