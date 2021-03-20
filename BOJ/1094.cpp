#include <iostream>

using namespace std;

int main()
{
	int num, cnt = 1;
	cin >> num;

	while (num != 1)
	{
		if (num % 2 == 1) cnt++;
		num = num / 2;
	}
	cout << cnt << endl;
}