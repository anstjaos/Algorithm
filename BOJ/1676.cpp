#include <iostream>
using namespace std;

long long factorial =1;
int cnt, num;

int main()
{
	cin >> num;
	for (int i = num; i > 0; i--) factorial *= i;

	while (1)
	{
		if (factorial % 10 == 0) cnt++;
		else break;

		factorial /= 10;
	}

	cout << cnt << "\n";
	return 0;
}