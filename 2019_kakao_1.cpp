#include <string>
#include <vector>
#include <map>
using namespace std;


vector<string> solution(vector<string> record) {
	vector<string> answer;
	string ret = "";
	map<string, string> userList;

	int recordSize = record.size();
	for (register int r = 0; r < recordSize; r++) {
		int size = record[r].size();
		register int i = 0;
		string uid = "", name = "";

		switch (record[r][0]) {
		case 'E':
		case 'L':
			i = 6;
			break;
		case 'C':
			i = 7;
			break;
		}

		for (; record[r][i] != ' ' && i < size; i++) {
			uid += record[r][i];
		}
		while (1)
		{
			i++;
			if (i >= size) break;
			name += record[r][i];
		}
		
		switch (record[r][0]) {
		case 'E':
		case 'C':
			userList[uid] = name;
			break;
		}
	}

	for (register int r = 0; r < recordSize; r++) {
		int size = record[r].size();
		register int i = 0;
		string uid = "", name = "";

		switch (record[r][0]) {
		case 'E':
		case 'L':
			i = 6;
			break;
		case 'C':
			i = 7;
			break;
		}

		for (; record[r][i] != ' ' && i < size; i++) {
			uid += record[r][i];
		}

		string text = "";
		name = userList[uid];
		switch (record[r][0]) {
		case 'E':
			text = name + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
			answer.push_back(text);
			break;
		case 'L':
			text = name + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
			answer.push_back(text);
			break;
		}
	}
	
	return answer;
}

int main()
{
	vector<string> record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
	solution(record);
}