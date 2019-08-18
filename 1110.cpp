#include <iostream>
using namespace std;

int cnt = 0;
int num;
int first;
int second;
int anonum;

int main()
{
	cin >> num;
	anonum = num;

	while (1)
	{
		first = anonum / 10;
		second = anonum % 10;
		anonum = second * 10 + ((first + second) % 10);
		cnt++;
		if (anonum == num) break;
	}
	cout << cnt << endl;
	return 0;
}