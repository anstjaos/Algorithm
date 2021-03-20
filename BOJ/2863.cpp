#include <iostream>
#include <algorithm>
using namespace std;

double a, b, c, d, arr[4];
double maxNum = -1, minNum = 2123456789;
int maxIndex, minIndex;

int main()
{
	cin >> a >> b >> c >> d;

	arr[0] = (a / c) + (b / d);
	arr[1] = (c / d) + (a / b);
	arr[2] = (d / b) + (c / a);
	arr[3] = (b / a) + (d / c);

	for (int i = 0; i < 4; i++)
	{
		if (arr[i] > maxNum)
		{
			maxNum = arr[i];
			maxIndex = i;
		}
		if (arr[i] < minNum)
		{
			minNum = arr[i];
			minIndex = i;
		}
	}

	bool flag = false;
	for (int i = 0; i < 4; i++)
	{
		if (i == maxIndex) continue;

		if (arr[i] == maxNum)
		{
			flag = true;
			break;
		}
	}

	if (flag == true) cout << minIndex << endl;
	else cout << maxIndex << endl;

	return 0;
}