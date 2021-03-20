#include <iostream>
using namespace std;

int electronics[101],elecCnt, arr[101], arrCnt;
int result = 0;

int findChange(int cnt, int cur)
{
	int index, value, temp = -1;
	for (int i = 0; i < cnt; i++)
	{
		value = -1;
		for (int j = cur+1; j < arrCnt; j++)
		{
			if(electronics[i] == arr[j] )
			{
				value = j;
				break;
			}
		}

		if (value == -1) return i;
		if (value > temp)
		{
			temp = value;
			index = i;
		}
	}
	return index;
}

void solve()
{
	bool exist = false;
	int curCnt = 0, changeIndex;
	for (int i = 0; i < arrCnt; i++)
	{
		exist = false;
		for (int j = 0; j < curCnt; j++)
		{
			if (electronics[j] == arr[i])
			{
				exist = true;
				break;
			}
		}

		if (exist == true) continue;
		if (curCnt != elecCnt)
		{
			electronics[curCnt++] = arr[i];
		}
		else
		{
			changeIndex = findChange(curCnt, i);
			result++;
			electronics[changeIndex] = arr[i];
		}
	}
}

int main()
{
	cin >> elecCnt >> arrCnt;
	for (int i = 0; i < arrCnt; i++) cin >> arr[i];

	solve();
	cout << result << '\n';
	return 0;
}