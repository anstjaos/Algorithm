#include <iostream>
using namespace std;

int testCase;
int arr[101] = { 0, }; //0 close 1 open

void init()
{
	for (int i = 0; i < 101; i++) arr[i] = 0;
}
int main()
{
	cin >> testCase;
	int round;
	int cnt;
	for (int i = 0; i < testCase; i++)
	{
		cin >> round;
		init();
		for (int j = 1; j <= round; j++)
		{
			cnt = 1;
			for (int k = j; k <= round; k=j*cnt)
			{
				if (arr[k] == 0) arr[k] = 1;
				else arr[k] = 0;

				cnt++;
			}
		}
		int result = 0;
		for (int k = 1; k <= round; k++)
		{
			if (arr[k] == 1) result++;
		}
		cout << result << endl;
	}
}