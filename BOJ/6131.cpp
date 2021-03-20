#include <iostream>
using namespace std;

int cnt = 0;
int n;
int aDefault;

int main()
{
	cin >> n;
	while (aDefault * aDefault <= n) aDefault++;

	for (int i = aDefault; i <= 500; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			if ((i*i) - (j *j) == n) cnt++;
		}
	}

	cout << cnt << endl;
}