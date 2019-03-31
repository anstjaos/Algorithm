#include <iostream>
using namespace std;

int H, M;

int main()
{
	cin >> H >> M;

	M -= 45;
	if (M < 0)
	{
		M += 60;
		H = (H - 1 + 24) % 24;
	}

	cout << H << " " << M << "\n";
	return 0;
}