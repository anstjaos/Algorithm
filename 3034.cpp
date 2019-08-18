#include <iostream>
#include <math.h>
using namespace std;

int n, w, h;

int main()
{
	cin >> n >> w >> h;
	
	int temp = (int)sqrt((w*w) + (h*h));

	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		if (num <= temp) cout << "DA\n";
		else cout << "NE\n";
	}

	return 0;
}