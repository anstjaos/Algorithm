#include <iostream>
using namespace std;

int row, col, arr[1001][1001];
bool check[1001][1001];
long long result;

int main()
{
	scanf("%d %d", &row, &col);

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			scanf("%d", &arr[i][j]);
			result += arr[i][j];
		}
	}

	int maxIndex = 0;
	
	for (int i = 0; i < row; i++)
	{
		int maxIndex = 0;
		for (int j = 0; j < col; j++)
		{
			if (arr[i][j] > arr[i][maxIndex]) maxIndex = j;
		}
		check[i][maxIndex] = true;
	}

	for (int i = 0; i < col; i++)
	{
		int maxIndex = 0;
		for (int j = 0; j < row; j++)
		{
			if (arr[j][i] > arr[maxIndex][i]) maxIndex = j;
		}
		check[maxIndex][i] = true;
	}

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (check[i][j] == true) result -= arr[i][j];
		}
	}

	printf("%lld\n", result);
	return 0;
}