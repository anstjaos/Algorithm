#include <iostream>
using namespace std;


int main()
{
	int k, n, m;

	cin >> k >> n >> m;
	int result = m - (k*n);

	if (result > 0) cout << "0" << endl;
	else cout << -result << endl;
}