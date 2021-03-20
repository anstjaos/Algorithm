#include <iostream>
using namespace std;

int computerCnt;
int pairCnt;
int arr[101][101] = { 0, };
int check[101] = { 0, };
int x, y;
int cnt = 0;

void search(int index)
{
	check[index] = 1;
	cnt++;
	for (int i = 1; i <= computerCnt; i++)
	{
		if (arr[index][i] == 1 && check[i] == 0)
		{
			search(i);
		}
	}
}

int main()
{
	cin >> computerCnt >> pairCnt;
	check[1] = 1;
	for (int i = 0; i < pairCnt; i++)
	{
		cin >> x >> y;
		arr[x][y] = 1;
		arr[y][x] = 1;
	}
	search(1);

	cout << cnt-1 << endl;
}