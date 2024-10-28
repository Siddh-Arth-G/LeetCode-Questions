/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(otherVal) {
            if (val === otherVal) {
                return true; // Return true if equal
            } else {
                throw new Error("Not Equal"); // Throw error if not equal
            }
        },
        notToBe: function(otherVal) {
            if (val !== otherVal) {
                return true; // Return true if not equal
            } else {
                throw new Error("Equal"); // Throw error if equal
            }
        }
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */