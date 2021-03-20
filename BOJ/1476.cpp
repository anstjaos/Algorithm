#include <iostream>
using namespace std;

int e, s, m;
int x = 0;
int main()
{
	cin >> e >> s >> m;

	while (1)
	{
		int r1 = x % 15 + 1;
		int r2 = x % 28 + 1;
		int r3 = x % 19 + 1;
		if (r1 == e && r2 == s && r3 == m)break;
		x++;
	}
	cout << x+1 << endl;
	return 0;
}