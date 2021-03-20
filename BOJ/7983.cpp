#include <iostream>
using namespace std;

int testCase;
int d, t;
long long maxNum = 0;
long long maxDate = 0;
int temp;
bool check[100000001];

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> d >> t;
		temp = t - d +1;
		if (t > maxDate) maxDate = t;
		for (int j = 0; j < d; j++)
		{
			if (check[temp + j] == true)
			{
				int index = 1;
				while (1)
				{
					if (temp + j - index < 0) break;
					if (check[temp + j - index] == false)
					{
						check[temp + j - index] = true;
						break;
					}
					else index++;
				}
				continue;
			}
			check[temp + j] = true;
		}
	}

	int index = 0;
	for (int i = 0; i <= maxDate; i++)
	{
		bool flag = false;
		if (check[i] == false)
		{
			int cnt = 0;
			for (int j = i; j <= maxDate; j++)
			{
				if (check[j] == false) cnt++;
				else
				{
					index = j - 1;
					flag = true;
					break;
				}
			}
			if (cnt > maxNum) maxNum = cnt;
			if(index >0 && flag == true) i = index;
		}
	}

	cout << maxNum - 1 << endl;
	return 0;
}