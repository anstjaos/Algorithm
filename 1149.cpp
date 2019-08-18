#include <iostream>
#include <algorithm>
using namespace std;

int result[1000][3];

int main()
{
	int cnt;
	cin >> cnt;
	int r, g, b;
	
	cin >> result[0][0] >> result[0][1] >> result[0][2];
	for (int i = 1; i < cnt; i++)
	{
		cin >> r >> g >> b;

		result[i][0] = r + min(result[i - 1][1], result[i - 1][2]);
		result[i][1] = g + min(result[i - 1][0], result[i - 1][2]);
		result[i][2] = b + min(result[i - 1][0], result[i - 1][1]);
	}
	
	cout << min(min(result[cnt - 1][0], result[cnt - 1][1]), result[cnt - 1][2]) << endl;
	return 0;
}