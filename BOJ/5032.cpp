#include <iostream>
using namespace std;

int e, f, c;

int main()
{
	cin >> e >> f >> c;

	int cnt = (e + f) / c;
	int empty;
	int a = cnt + (e+f) %c;
	while (1)
	{
		empty = a / c;
		a = a % c + empty;
		
		cnt += empty;
		if (a < c) break;
	}
	cout << cnt << endl;
	return 0;
}