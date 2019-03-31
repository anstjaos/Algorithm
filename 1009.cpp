#include <iostream>
using namespace std;

int testCase;
int a, b;
int arr[100000001];
int cnt;
int temp;

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		cin >> a >> b;
		temp = 1;
		cnt = 0;
		if (a % 10 == 0)
		{
			cout << "10" << endl;
			continue;
		}

		for (int j = 0; j < b; j++)
		{
			temp = (temp * a) % 10;

			if (cnt == 0)
			{
				arr[0] = temp;
			}
			else
			{
				if (temp == arr[0])
				{
					break;
				}
				else
				{
					arr[cnt] = temp;
				}
			}
			cnt++;
		}

		int index = (b - 1) % cnt;
		cout << arr[index] << endl;
	}
	return 0;
}