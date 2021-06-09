require 'test/unit'

class TestCamouflage < Test::Unit::TestCase

    def test_case_one
        assert_equal(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]), 5)
    end

    def test_case_two
        assert_equal(solution([["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]), 3)
    end

    def solution(clothes)
        answer = 0
        type = {}
        
        clothes.each_with_index do |array|
            if type.key?(array[1].to_sym)
                type[array[1].to_sym].push(array[0])
            else
               type.store(array[1].to_sym, [array[0]]) 
            end
        end
        
        answer = 1
            
        type.each do |key, value|
            answer *= (value.length+1) 
        end
        
        return answer-1
    end

end
