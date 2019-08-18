#include <iostream>
using namespace std;

int arr[301][301];
int dp[301][301];
int a, b, x, y;
int k;
int row, col;

int main()
{
	cin >> row >> col;
	for (int i = 1; i <= row; i++)
	{
		for (int j = 1; j <= col; j++)
		{
			cin >> arr[i][j];
		
			 dp[i][j] = arr[i][j] + dp[i][j - 1];
		}
	}
	cin >> k;
	for (int i = 0; i < k; i++)
	{
		int sum = 0;
		cin >> a >> b >> x >> y;
		for (int j = a; j <= x; j++)
		{
			sum += dp[j][y] - dp[j][b - 1];
		}
		cout << sum << endl;
	}
}