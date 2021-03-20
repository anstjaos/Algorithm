#include <iostream>
using namespace std;


int main() {



	int pos1;
	int pos2;
	int sol = 0;
	cin >> pos1 >> pos2;
	pos1--;
	pos2--;
	if (pos1 > pos2) swap(pos1, pos2);
	while ((pos1 / 4) != (pos2 / 4)) {
		sol++;
		pos1 += 4;

	}
	cout << sol + abs(pos1 - pos2) << endl;

	return 0;
}

