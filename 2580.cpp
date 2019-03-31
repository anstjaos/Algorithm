#include <iostream>
using namespace std;

typedef struct {
	int row, col;
}pt;

pt zeroArr[82];
int map[10][10], cnt;

bool checkCol(int num, pt temp)
{
	for (int i = 0; i < 9; i++)
	{
		if (map[temp.row][i] == num) return false; 
	}
	return true;
}

bool checkRow(int num, pt temp)
{
	for (int i = 0; i < 9; i++)
	{
		if (map[i][temp.col] == num) return false;
	}
	return true;
}

bool checkSquare(int num, pt temp)
{
	for (int i = temp.row/3*3; i < (temp.row/3 +1) *3; i++)
	{
		for (int j = temp.col / 3*3; j < (temp.col / 3 + 1) * 3; j++)
		{
			if (map[i][j] == num) return false;
		}
	}
	return true;
}

bool solve(int index)
{
	if (index == cnt) return true;
	pt cur = zeroArr[index];

	for (int i = 1; i <= 9; i++)
	{
		if (checkCol(i, cur) && checkRow(i, cur) && checkSquare(i, cur))
		{
			map[cur.row][cur.col] = i;
			if (solve(index + 1)) return true;
			map[cur.row][cur.col] = 0;
		}
	}

	return false;
}

int main()
{
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			scanf("%d", &map[i][j]);
			if (map[i][j] == 0) zeroArr[cnt++] = { i,j };
		}
	}

	solve(0);

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++) printf("%d ", map[i][j]);
		printf("\n");
	}

	return 0;
}