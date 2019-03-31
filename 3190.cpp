#include <iostream>
using namespace std;

char map[10001][501];
int check[10001][501];
int row, col, result = 0;

bool isSafeplace(int x, int y)
{
	if (x < 0 || x >= row) return false;
	if (map[x][y] != '.' || check[x][y] == 1) return false;

	check[x][y] = 1;
	return true;
}

int backtracking(int x, int y)
{
	if (isSafeplace(x, y))
	{
		if (y == col - 1) return 1;


		if (backtracking(x - 1, y + 1) == 1) return 1;
		if (backtracking(x, y + 1) == 1) return 1;
		if (backtracking(x + 1, y + 1) == 1) return 1;

	}
	
	return 0;
}

void solve()
{
	for (int i = 0; i < row; i++)
	{
		result = result + backtracking(i, 0);
	}
}
int main()
{
	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> map[i];

	solve();
	cout << result << endl;
	return 0;
}